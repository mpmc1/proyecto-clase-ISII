package com.mipresupuesto.personalbudget.crosscuting.utils;

import java.util.UUID;

public class UtilUUID {
	public static final String DEFAULT_UUID_STRING ="00000000-0000-0000-0000-000000000000";
	public static final UUID DEFAULT_UUID =UUID.fromString(DEFAULT_UUID_STRING);
	private UtilUUID() {
		super();
	}
	public static final UUID getDefaultUUID(final UUID uuid) {
		return (uuid == null) ? DEFAULT_UUID:uuid;
	}
	public static final UUID getNewUUID() {
		UUID uuid;
		do{
			uuid = UUID.randomUUID();
		}while(isEqual(uuid, DEFAULT_UUID));
			return uuid;
	}
	public static final boolean isEqual(final UUID uuidOne, final UUID uuidTwo) {
		return getDefaultUUID(uuidOne).equals(getDefaultUUID(uuidTwo));
	}
	public static final UUID getUuidFromString(String id) {
		UUID uuid = DEFAULT_UUID;
		if(id != null && !"".equals(id.trim())) {
			try {
				uuid = UUID.fromString(id);
			}catch(IllegalArgumentException exception) {
			}
		}
		return uuid;
	}
	public static final String getStringFromUuid(UUID id) {
		String uuidString= DEFAULT_UUID_STRING;
		if(id == null) {
			uuidString = id.toString();
		}
		return uuidString;
	}
	
	public static boolean isNull(UUID value) {
		return UtilObject.getUtilObject().isNull(value);}

}
