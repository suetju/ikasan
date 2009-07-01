/*
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
package org.ikasan.framework.event.exclusion.dao;

import java.util.List;

import org.ikasan.framework.error.model.ErrorOccurrence;
import org.ikasan.framework.event.exclusion.model.ExcludedEvent;
import org.ikasan.framework.management.search.PagedSearchResult;

/**
 * @author The Ikasan Development Team
 *
 */
public interface ExcludedEventDao{

	/**
	 * Saves an <code>ExcludedEvent</code> to persistent storage
	 * 
	 * @param excludedEvent
	 */
	public void save(ExcludedEvent excludedEvent);
	
	/**
	 * Loads an <code>ExcludedEvent</code> to persistent storage
	 * 
	 * @param excludedEventId
	 */
	public ExcludedEvent load(Long excludedEventId);

	/**
	 * Perform a paged search for <code>ExcludedEvent</code>s
	 * 
	 * @param pageNo
	 * @param pageSize
	 * 
	 * @return PagedSearchResult
	 */
	public PagedSearchResult<ExcludedEvent> findExcludedEvents(int pageNo, int pageSize);

	/**
	 * Retrieves an ExcludedEvent by id
	 * 
	 * @param id
	 * @return ExcludedEvent
	 */
	public ExcludedEvent getExcludedEvent(long excludedEventId);

	
	/**
	 * Deletes excluded event
	 * 
	 * @param excludedEvent
	 */
	public void delete(ExcludedEvent excludedEvent);

}
