import org.apache.log4j.Logger

class LogService {
    static void logMessages(Logger logger, String parameter){

        logger.trace("This is trace : " + parameter);
        logger.debug("This is debug : " + parameter);
        logger.info("This is info : " + parameter);
        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);
    }
}
