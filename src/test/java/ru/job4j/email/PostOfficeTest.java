package ru.job4j.email;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostOfficeTest  {
     @Test
    public void testFusion() {
         Map<User, Set<Email>> userSetMap = new LinkedHashMap<>();
         userSetMap.put(new User("user1"), Set.of(new Email("xxx@ya.ru"),new Email("foo@gmail.com"),
                 new Email("lol@mail.ru")));
         userSetMap.put(new User("user2"), Set.of(new Email("foo@gmail.com"),new Email("ups@pisem.net")));
         userSetMap.put(new User("user3"), Set.of(new Email("xyz@pisem.net"),new Email("vasya@pupkin.com")));
         userSetMap.put(new User("user4"), Set.of(new Email("ups@pisem.net"),new Email("aaa@bbb.ru")));
         userSetMap.put(new User("user5"), Set.of(new Email("xyz@pisem.net")));
         PostOffice postOffice = new PostOffice();
         Map<User, Set<Email>> userSetMapTest = new LinkedHashMap<>();
         userSetMapTest.put(new User("user1"), Set.of(new Email("xxx@ya.ru"),new Email("foo@gmail.com"),
                 new Email("lol@mail.ru"),new Email("ups@pisem.net"),new Email("aaa@bbb.ru")));
         userSetMapTest.put(new User("user3"), Set.of(new Email("xyz@pisem.net"),new Email("vasya@pupkin.com")));
         assertThat(postOffice.fusion(userSetMap), is(userSetMapTest));
     }

//    user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
//    user2 ->foo@gmail.com,ups@pisem.net
//    user3 ->xyz@pisem.net,vasya@pupkin.com
//    user4 ->ups@pisem.net,aaa@bbb.ru
//    user5 ->xyz@pisem.net
//     user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
//     user3 ->xyz@pisem.net,vasya@pupkin.com
}