/* 
 * $Id$
 * $URL$
 *
 * ====================================================================
 * Ikasan Enterprise Integration Platform
 * 
 * Distributed under the Modified BSD License.
 * Copyright notice: The copyright for this software and a full listing 
 * of individual contributors are as shown in the packaged copyright.txt 
 * file. 
 * 
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 *
 *  - Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 *
 *  - Neither the name of the ORGANIZATION nor the names of its contributors may
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE 
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 */
package org.ikasan.sample.jmsDrivenPriceSrc.integrationTest;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;

import org.ikasan.consumer.jms.GenericJmsConsumerConfiguration;
import org.ikasan.flow.configuration.dao.ConfigurationDao;
import org.ikasan.flow.configuration.service.ConfigurationManagement;
import org.ikasan.flow.configuration.service.ConfigurationService;
import org.ikasan.flow.configuration.service.ConfiguredResourceConfigurationService;
import org.ikasan.flow.event.FlowEventFactory;
import org.ikasan.recovery.ScheduledRecoveryManagerFactory;
import org.ikasan.sample.jmsDrivenPriceSrc.flow.PriceFlowFactory;
import org.ikasan.scheduler.SchedulerFactory;
import org.ikasan.spec.component.endpoint.Consumer;
import org.ikasan.spec.component.endpoint.Producer;
import org.ikasan.spec.flow.Flow;
import org.ikasan.spec.flow.FlowEventListener;
import org.ikasan.trigger.dao.TriggerDao;
import org.ikasan.wiretap.listener.JobAwareFlowEventListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Ikasan Development Team
 */
@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations={
        "/configuration-dao-config.xml", 
        "/trigger-dao-config.xml", 
        "/hsqldb-config.xml"})
      
public class PriceFlowSampleTest
{
    /** Spring DI resource */
    @Resource ConfigurationDao staticConfigurationDao;
    
    /** Spring DI resource */
    @Resource ConfigurationDao dynamicConfigurationDao;
    
    /** Spring DI resource */
    @Resource TriggerDao triggerDao;
    
    /** flow event factory */
    FlowEventFactory flowEventFactory = new FlowEventFactory();
    
    /** configuration service */
    ConfigurationService configurationService;
    
    /** configuration management for the scheduled consumer */
    ConfigurationManagement<Consumer,GenericJmsConsumerConfiguration> configurationManagement;
    
    /** recovery manager */
    ScheduledRecoveryManagerFactory scheduledRecoveryManagerFactory;
    
    /** flow event listener */
    FlowEventListener flowEventListener;
    
    @Before
    public void setup() 
    {
        this.scheduledRecoveryManagerFactory  = 
            new ScheduledRecoveryManagerFactory(SchedulerFactory.getInstance().getScheduler());
        
        configurationService = new ConfiguredResourceConfigurationService(staticConfigurationDao, dynamicConfigurationDao);
        configurationManagement = (ConfigurationManagement<Consumer,GenericJmsConsumerConfiguration>)configurationService;
        flowEventListener = new JobAwareFlowEventListener(null, triggerDao);
    }

    @Test
    public void test_flow_consumer_translator_producer() throws JMSException
    {
        PriceFlowFactory priceFlowFactory = 
            new PriceFlowFactory("flowName", "moduleName", this.configurationService, this.configurationManagement, flowEventListener);
        Flow priceFlow = priceFlowFactory.createJmsDrivenFlow();

        // we need an instance of a producer to poke the first message to the JMS destination
        Producer testProducer = priceFlowFactory.createProducer("testProducerId");
        priceFlow.start();
        
        testProducer.invoke(priceFlowFactory.createTextMessage("text message 1"));
        testProducer.invoke(priceFlowFactory.createTextMessage("text message 2"));
        testProducer.invoke(priceFlowFactory.createTextMessage("text message 3"));
        testProducer.invoke(priceFlowFactory.createTextMessage("text message 4"));
        priceFlow.stop();
    }
}