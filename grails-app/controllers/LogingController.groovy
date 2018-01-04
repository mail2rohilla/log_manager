
import org.apache.log4j.Level
import org.apache.log4j.Logger

class LogingController {

    LogService logService
    static int count = 0
    final static synchronized Logger logger = Logger.getLogger(Resources.LOGGER_NAME)

    public static void main(String[] args)
    {
        println(LogingController.getClass().getPackage())
        println(getStaticApplicationContext())
    }
    def index()
    {
        Thread th = new Thread(new Runnable() {

            void run() {
                LogService.logMessages(logger, logger.name)
                try{
                    Thread.sleep(5000)
                    if(count++ < 10)
                    {
                        run()
                    }
                }
                catch (Exception e)
                {
                    logger.error("thread error encountered")
                }
            }
        })

        th.start()

        render "thread started"
    }



    def changePriority()
//    def changePriority(Level level)
    {
        Logger logger = Logger.getLogger("newLogingLogger")
//        logger.setLevel(level)
        logger.setLevel(Level.DEBUG)

        render "level changed to debug"
    }
}
