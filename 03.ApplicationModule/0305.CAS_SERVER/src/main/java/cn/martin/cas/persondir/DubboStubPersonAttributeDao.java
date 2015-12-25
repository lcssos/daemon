package cn.martin.cas.persondir;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.StubPersonAttributeDao;

import java.util.*;

/**
 * Created by lcssos on 15/12/25.
 */
public class DubboStubPersonAttributeDao extends StubPersonAttributeDao {
    public DubboStubPersonAttributeDao() {
    }

    public DubboStubPersonAttributeDao(Map backingMap) {
        super(backingMap);
    }


    public IPersonAttributes getPerson(String uid){
//        HashMap m = new HashMap(this.getBackingMap());
        Map<String,List<Object>> m = new HashMap<>();
////        m.put("username",uid);
        List<Object> r = new ArrayList<>();
        r.add("R_USER");
        m.put("roles",r);
        List<Object> p = new ArrayList<>();
        p.add("P_USER");
        m.put("permissions",p);
        this.setBackingMap(m);
        return super.getPerson(uid);
    }

    public final Set<IPersonAttributes> getPeopleWithMultivaluedAttributes(Map<String, List<Object>> query) {
        List list = (List)query.get("username");
        HashMap m = new HashMap(this.getBackingMap());
        m.put("username", list);
        m.put("roles","R_USER");
        m.put("permissions","P_USER");
        this.setBackingMap(m);
        return super.getPeopleWithMultivaluedAttributes(query);
    }
}
