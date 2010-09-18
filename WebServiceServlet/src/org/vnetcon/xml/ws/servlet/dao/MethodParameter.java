/*
 *    This file is part of WebServiceServlet (WSS).
 *
 *    WSS is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    WSS is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with WSS.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Copyright(c) 2010 Michael Kankkonen
 *    http://www.vnetcon.org
 */


package org.vnetcon.xml.ws.servlet.dao;

import java.lang.reflect.Type;

import org.vnetcon.xml.ws.servlet.schema.XmlBase;

/**
 * This class holds information of WebService method's
 * parameter.
 * 
 * 
 * @author Michael Kankkonen 17.9.2010 
 *         http://www.vnetcon.org
 *
 */
public class MethodParameter extends XmlBase {

	Type parameterClass = null;
	String schemaType = null;
	String parameterName = null;
	String parameterClassString = null;
	
	
	public MethodParameter(String parameterName, Type parameterClass) throws Exception {
		this.parameterName = parameterName;
		this.parameterClass = parameterClass;
		String strType = this.parameterClass.toString();
		
		if(strType.startsWith("class ")){
			strType = strType.replaceFirst("class ", "");
		}
		
//		System.out.println("  parameter: " + strType);
		this.schemaType = this.getSchemaType(strType);
		this.parameterClassString = strType;
	}

	public String getParameterName(){
		return this.parameterName;
	}
	
	public String getSchemaType(){
		return this.schemaType;
	}
	
	public String getParameterClassAsString(){
		return this.parameterClassString;
	}
	
	public Type getParameterType(){
		return this.parameterClass;
	}
	
}
