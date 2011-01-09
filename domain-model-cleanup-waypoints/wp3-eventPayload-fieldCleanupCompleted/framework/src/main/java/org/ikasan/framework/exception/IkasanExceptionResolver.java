/*
 * $Id$
 * $URL$
 * 
 * ====================================================================
 * Ikasan Enterprise Integration Platform
 * Copyright (c) 2003-2008 Mizuho International plc. and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the 
 * Free Software Foundation Europe e.V. Talstrasse 110, 40217 Dusseldorf, Germany 
 * or see the FSF site: http://www.fsfeurope.org/.
 * ====================================================================
 */
package org.ikasan.framework.exception;


/**
 * Ikasan Exception Resolver interface provides the defined operations in the context of resolving as Ikasan runtime
 * exception to a subsequent definition.
 * 
 * @author Ikasan Development Team
 */
public interface IkasanExceptionResolver
{
    /**
     * Resolve the given exception into a specific <code>IkasanExceptionDefinition</code>
     * 
     * @param thrown Exception that was thrown
     * @return IkasanExceptionResolution
     * @throws IkasanExceptionResolutionNotFoundException Exception if a resolution was not found
     */
    public IkasanExceptionResolution resolve(Throwable thrown) throws IkasanExceptionResolutionNotFoundException;

    /**
     * Resolve the given component name and exception into a specific <code>IkasanExceptionDefinition</code>
     * 
     * @param componentName The component that threw the Exception
     * @param thrown The exception that was thrown
     * @return IkasanExceptionResolution
     * @throws IkasanExceptionResolutionNotFoundException Exception if a resolution was not found
     */
    public IkasanExceptionResolution resolve(String componentName, Throwable thrown)
            throws IkasanExceptionResolutionNotFoundException;
}