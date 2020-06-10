package com.algorithm.day01;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@SpringBootTest
class Day01ApplicationTests {

	@Test
	void contextLoads() {


	}

	@Test
    void print(){
	    char[] carr=new char[]{'a','b','c','d','e'};
        printReverse(carr);
    }

    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if(str==null|| index>str.length-1){
            return;
        }
        System.out.println(str[str.length-1-index]);
        helper(++index,str);
    }


    @Test
    void print2n(){
        int i = printNext(2);
        printPrivos(i);
	}

    private int printNext(int n){
	    if(n>5000){
            System.out.println(n);

	        return n;
        }
        System.out.println(n);
	    return printNext(2*n);
    }

    private int printPrivos (int n){
	    if(n<=2){
            System.out.println(n);
            return n;
        }
        System.out.println(n);
	    return printPrivos(n/2);
    }



    @Test
    void calendar(){
	    Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        //Java8
        System.out.println("jdk8");
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());

        //如何取得从1970年1月1日0分0秒到现在的毫秒数
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        System.out.println(timeInMillis);
        long l = System.currentTimeMillis();
        System.out.println(l);
        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);


        //如何去的某月的最后一天
        LocalDate localDate=LocalDate.now();
        //本月的第一天
        LocalDate firstDay = localDate.of(localDate.getYear(), localDate.getMonth(), 1);
        //本月的最后一天
        LocalDate endDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天"+firstDay);
        System.out.println(endDay);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm/ss");
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);


    }



    @Test
    void println(){
	    LocalDate localDate=LocalDate.now();
	    //get the year ,check if it's leap year
        System.out.println("year "+localDate.getYear()+"is leap year ?"+localDate.isLeapYear());
        //compare two localdate for before and after
        System.out.println("Today is before 01/01/2015?"+localDate.isBefore(localDate.of(2015,1,1)));
        //create localdateTime for localdate
        System.out.println(localDate.atTime(LocalTime.now()));
        //plus and minus operations
        System.out.println("10 days after today will be "+localDate.plusDays(10));
        System.out.println("3 weeks after today will be "+localDate.plusWeeks(3));
        System.out.println("20 months after today will be "+localDate.plusMonths(20));
        // Temporal adjusters for adjusting the dates
        System.out.println("First date of this month="+localDate.
                with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayofYear = localDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year ="+lastDayofYear);
        Period period = localDate.until(lastDayofYear);
        System.out.println("period Format="+period);
        System.out.println("Months remaining in the year ="+period.getMonths());


    }


    @Test
    void parsingAndFormatting(){
	    LocalDate today = LocalDate.now();
        System.out.println("default format of localDate="+today);
        //specific format
        System.out.println(today.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(today.format(DateTimeFormatter.BASIC_ISO_DATE));
        LocalDateTime dateTime=LocalDateTime.now();
        //default format
        System.out.println(dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant="+timestamp);
        //Parse example
        System.out.println("Default format of Instant="+timestamp);

        //Parse example
        LocalDateTime dt = LocalDateTime.parse("28::4月::2020 16::35::04", DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing="+dt);

    }



    @Test
    void oldParseNew(){
	    //Date to instant
        Instant timestamp = new Date().toInstant();
        // Now we can conver Instant to LocalDateTime or other similar classes
        LocalDateTime date=LocalDateTime.ofInstant(timestamp,ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("Date="+date);

        //Calendar to instant
        Instant time = Calendar.getInstance().toInstant();
        System.out.println(time);
        //Timezone to ZoneId
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        System.out.println(defaultZone);
        //ZoneDateTIme from specific Calendar
        ZonedDateTime gregorianCalendarTime = new GregorianCalendar().toZonedDateTime();
        System.out.println(gregorianCalendarTime);

        //date api to legacy classes
        Date dt = Date.from(Instant.now());
        System.out.println(dt);


        TimeZone tz=TimeZone.getTimeZone(defaultZone);
        System.out.println(tz);

        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarTime);
        System.out.println(gc);


    }



    @Test
    void testClock() throws InterruptedException {
	    //时钟提供给我们用于访问某个特定 时区的 瞬间时间 日期 和时间
        Clock clock = Clock.systemUTC();//系统默认的UTC时钟(当前瞬时时间 System.currentTimeMills())
        System.out.println(clock.millis());
        Clock c2 = Clock.systemDefaultZone();//系统默认时区时钟
        Clock c3 = Clock.system(ZoneId.of("Europe/Paris"));//巴黎时间
        System.out.println(c3.millis());//每次调用返回当前瞬时时间
        System.out.println(Clock.system(ZoneId.of("Asia/Shanghai")).millis());
        Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));//固定上海时区时钟
        System.out.println(c4.millis());
        Thread.sleep(1000);
        System.out.println(c4.millis());
        Clock c5 = Clock.offset(clock, Duration.ofSeconds(2));//相对于系统默认时钟两秒的时钟
        System.out.println(clock.millis());
        System.out.println(c5.millis());
    }


    @Test
    void testInstant(){
	    //瞬时时间 相当于以前的System.currentTimeMillis()
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond()); //精确到秒 得到相对于1970-01-01 00:00:00UTC的一个时间
        System.out.println(instant.toEpochMilli()); //精确到毫秒
        Clock clock = Clock.systemUTC();
        Instant instant2 = Instant.now(clock);
        System.out.println(instant2.toEpochMilli());
        Clock clock2 = Clock.fixed(instant, ZoneId.systemDefault());//固定瞬时时间时钟
        Instant instant3 = Instant.now(clock2);
        System.out.println(instant3.toEpochMilli());


    }


    @Test
    public void testLocalDateTime(){
	    //使用默认时区时钟瞬时时间创建
        Clock.systemDefaultZone();//相对于ZoneId.SystemDefault()
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //自定义时区
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);
        //不需要写什么相对时间 如java.util.Date年是相对于1900 月是从0开始
        //2013-12-31 23:59
        LocalDateTime d1 = LocalDateTime.of(2013, 12, 31, 23, 59);
        LocalDateTime d2 = LocalDateTime.of(2013, 12, 31, 23, 59, 11);
        System.out.println(d1 +":"+d2);
        //使用瞬时时间加时区
        Instant instant = Instant.now();
        LocalDateTime d3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(d3);
        //解析String--->LocalDateTime
        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59");
        System.out.println(d4);

        //使用DateTimeFormatter API解析和格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013/12/31 23:59:59", formatter);
        System.out.println(d6);


        //时间获取

        //时间增减
        LocalDateTime d7 = d6.minusDays(1);
        LocalDateTime d8 = d7.plus(1, IsoFields.QUARTER_YEARS);
        System.out.println(d7);
        System.out.println(d8);
    }


    @Test
    void testDuration(){
	    //表示两个瞬时时间的时间段
        Duration d1 = Duration.between(Instant.ofEpochMilli(System.currentTimeMillis() - 123123123), Instant.now());
        //得到相应时差
        System.out.println(d1.toDays());
        System.out.println(d1.toHours());
        System.out.println(d1.toMinutes());
        System.out.println(d1.toMillis());
        System.out.println(d1.toNanos());
        //一天时差
        Duration d2 = Duration.ofDays(1);
        System.out.println(d2);

    }


    @Test
    void testChronology(){
        //提供对于java.unit.calendar的替换,提供对年历系统的支持
        Chronology c = HijrahChronology.INSTANCE;
        ChronoLocalDateTime<? extends ChronoLocalDate> d = c.localDateTime(LocalDateTime.now());
        System.out.println(d);
    }

    /**
     * 新旧日期转换
     */
    @Test
    void testNewOldDateConversion(){
        Instant instant = new Date().toInstant();
        Date date = Date.from(instant);
        System.out.println(instant);
        System.out.println(date);
    }








    @Test
    void test1(){

    }






}
@Data
class Person{
    private String name;
    private String sex;
}