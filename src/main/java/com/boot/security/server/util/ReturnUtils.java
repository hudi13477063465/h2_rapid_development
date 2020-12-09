package com.boot.security.server.util;

import java.util.HashMap;
import java.util.Map;

public class ReturnUtils {
	public static Map<String, Object> success(Object... args) {
		Map<String, Object> rsl = new HashMap<String, Object>();
		for (int i = 0; i < args.length; i++) {
			rsl.put(args[i].toString(), args[++i]);
		}
		rsl.put("success", "0000");
		return rsl;
	}

	public static Map<String, Object> fail(Object... args) {
		Map<String, Object> rsl = new HashMap<String, Object>();
		for (int i = 0; i < args.length; i++) {
			rsl.put(args[i].toString(), args[++i]);
		}
		rsl.put("success", "");//一定要穿空字符串,否则前台会被当成true
		return rsl;
	}
}
