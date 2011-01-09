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
package org.ikasan.connector.sftp.consumer.type;

import junit.framework.Assert;

import org.ikasan.connector.base.outbound.EISConnectionFactory;
import org.ikasan.connector.sftp.consumer.SftpConsumerConfiguration;
import org.ikasan.connector.sftp.outbound.SFTPConnectionSpec;
import org.ikasan.framework.factory.DirectoryURLFactory;
import org.ikasan.spec.endpoint.Consumer;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link PayloadBasedSftpConsumerFactory}
 * 
 * @author Ikasan Development Team
 *
 */
public class PayloadBasedSftpConsumerFactoryTest
{
    Mockery mockery = new Mockery()
    {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    /** mock connectionFactory */
    final EISConnectionFactory connectionFactory = mockery.mock(EISConnectionFactory.class, "mockConnectionFactory");
    
    /** mock sftpConfiguration */
    final SftpConsumerConfiguration sftpConfiguration = mockery.mock(SftpConsumerConfiguration.class, "mockSftpConfiguration");

    /** mock SFTPConnectionSpec */
    final SFTPConnectionSpec sftpConnectionSpec = mockery.mock(SFTPConnectionSpec.class, "mockSFTPConnectionSpec");

    /** mock DirectoryURLFactory */
    final DirectoryURLFactory directoryURLFactory = mockery.mock(DirectoryURLFactory.class, "mockDirectoryURLFactory");

    /** mock consumer */
    final Consumer<?> consumer = mockery.mock(Consumer.class, "mockConsumer");

    /** instance on test */
    PayloadBasedSftpConsumerFactory payloadBasedSftpConsumerFactory;

    /**
     * Test failed constructor due to null connectionFactory.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_failedConstructor_nullConnectionFactory()
    {
        new PayloadBasedSftpConsumerFactory(null);
    }

    /**
     * Create a clean test instance prior to each test.
     */
    @Before
    public void setUp()
    {
        this.payloadBasedSftpConsumerFactory = new PayloadBasedSftpConsumerFactoryWithMockSpec(connectionFactory);
    }
    
    /**
     * Test create consumer invocation.
     */
    @Test
    public void test_createConsumer()
    {
        // expectations
        mockery.checking(new Expectations()
        {
            {
                exactly(1).of(sftpConfiguration).setSourceDirectoryURLFactory(null);
                
                exactly(1).of(sftpConfiguration).getClientID();
                will(returnValue("clientID"));
                one(sftpConnectionSpec).setClientID("clientID");

                exactly(1).of(sftpConfiguration).getRemoteHost();
                will(returnValue("hostname"));
                one(sftpConnectionSpec).setRemoteHostname("hostname");

                exactly(1).of(sftpConfiguration).getKnownHostsFilename();
                will(returnValue("knownhosts"));
                one(sftpConnectionSpec).setKnownHostsFilename("knownhosts");

                exactly(1).of(sftpConfiguration).getMaxRetryAttempts();
                will(returnValue(1));
                one(sftpConnectionSpec).setMaxRetryAttempts(1);

                exactly(1).of(sftpConfiguration).getRemotePort();
                will(returnValue(23));
                one(sftpConnectionSpec).setRemotePort(23);

                exactly(1).of(sftpConfiguration).getPrivateKeyFilename();
                will(returnValue("PrivateKeyFilename"));
                one(sftpConnectionSpec).setPrivateKeyFilename("PrivateKeyFilename");

                exactly(1).of(sftpConfiguration).getConnectionTimeout();
                will(returnValue(234));
                one(sftpConnectionSpec).setConnectionTimeout(234);

                exactly(1).of(sftpConfiguration).getUsername();
                will(returnValue("username"));
                one(sftpConnectionSpec).setUsername("username");

                exactly(1).of(sftpConfiguration).getCleanupJournalOnComplete();
                will(returnValue(Boolean.TRUE));
                one(sftpConnectionSpec).setCleanupJournalOnComplete(Boolean.TRUE);
            }
        });
                
        // test
        Assert.assertTrue(payloadBasedSftpConsumerFactory.createEndpoint(sftpConfiguration) instanceof PayloadBasedSftpConsumer);
        mockery.assertIsSatisfied();
    }
    
    /**
     * Test create consumer invocation.
     */
    @Test
    public void test_createConsumerWithDirectoryURLFactory()
    {
        // expectations
        mockery.checking(new Expectations()
        {
            {
                exactly(1).of(sftpConfiguration).setSourceDirectoryURLFactory(directoryURLFactory);
                
                exactly(1).of(sftpConfiguration).getClientID();
                will(returnValue("clientID"));
                one(sftpConnectionSpec).setClientID("clientID");

                exactly(1).of(sftpConfiguration).getRemoteHost();
                will(returnValue("hostname"));
                one(sftpConnectionSpec).setRemoteHostname("hostname");

                exactly(1).of(sftpConfiguration).getKnownHostsFilename();
                will(returnValue("knownhosts"));
                one(sftpConnectionSpec).setKnownHostsFilename("knownhosts");

                exactly(1).of(sftpConfiguration).getMaxRetryAttempts();
                will(returnValue(1));
                one(sftpConnectionSpec).setMaxRetryAttempts(1);

                exactly(1).of(sftpConfiguration).getRemotePort();
                will(returnValue(23));
                one(sftpConnectionSpec).setRemotePort(23);

                exactly(1).of(sftpConfiguration).getPrivateKeyFilename();
                will(returnValue("PrivateKeyFilename"));
                one(sftpConnectionSpec).setPrivateKeyFilename("PrivateKeyFilename");

                exactly(1).of(sftpConfiguration).getConnectionTimeout();
                will(returnValue(234));
                one(sftpConnectionSpec).setConnectionTimeout(234);

                exactly(1).of(sftpConfiguration).getUsername();
                will(returnValue("username"));
                one(sftpConnectionSpec).setUsername("username");

                exactly(1).of(sftpConfiguration).getCleanupJournalOnComplete();
                will(returnValue(Boolean.TRUE));
                one(sftpConnectionSpec).setCleanupJournalOnComplete(Boolean.TRUE);            }
        });
                
        // test
        PayloadBasedSftpConsumerFactory payloadBasedSftpConsumerFactory = new PayloadBasedSftpConsumerFactoryWithMockSpec(connectionFactory,directoryURLFactory);
        Assert.assertTrue(payloadBasedSftpConsumerFactory.createEndpoint(sftpConfiguration) instanceof PayloadBasedSftpConsumer);
        mockery.assertIsSatisfied();
    }
    
    /**
     * Test PayloadBasedSftpConsumerFactory instance to allow us to return a mock 
     * instance of the ConnectionSpec.
     * @author Ikasan Development Team
     *
     */
    private class PayloadBasedSftpConsumerFactoryWithMockSpec extends PayloadBasedSftpConsumerFactory
    {

        public PayloadBasedSftpConsumerFactoryWithMockSpec(EISConnectionFactory connectionFactory)
        {
            super(connectionFactory);
        }

        public PayloadBasedSftpConsumerFactoryWithMockSpec(EISConnectionFactory connectionFactory, DirectoryURLFactory directoryURLFactory)
        {
            super(connectionFactory, directoryURLFactory);
        }

        @Override
        protected SFTPConnectionSpec getConnectionSpec()
        {
            return sftpConnectionSpec;
        }
    }
    
}