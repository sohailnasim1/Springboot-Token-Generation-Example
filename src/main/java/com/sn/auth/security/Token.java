/**
 * Stores token data
 * 
 * @author Sohail Nasim
 */
package com.sn.auth.security;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Token implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String token;
	private long issueAt;
	private int expiry;

}
