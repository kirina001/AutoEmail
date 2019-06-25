package com.testing.webTest;

import org.apache.log4j.Logger;

public class Log4jTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Logger logger = Logger.getLogger(Log4jTest.class);

		    // Use the default configuration.
		    //BasicConfigurator.configure();

		    // Set the logger level to Level.INFO
//		    logger.setLevel(Level.INFO);

		    // This request will be disabled since Level.DEBUG < Level.INFO.
		    logger.debug("This is debug.");

		    // These requests will be enabled.
		    logger.info("This is an info.");
		    logger.info("----------------------------测试开始---------------------");
		    logger.warn("This is a warning.");
		    try {
				Integer.parseInt("ss");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				logger.error(e,e.fillInStackTrace());
			}
		    
		    logger.fatal("This is a fatal error.");

		    return;
	}

}
