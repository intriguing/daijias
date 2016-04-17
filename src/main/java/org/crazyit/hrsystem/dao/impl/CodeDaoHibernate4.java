package org.crazyit.hrsystem.dao.impl;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.CodeDao;
import org.crazyit.hrsystem.domain.Code;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public class CodeDaoHibernate4 extends BaseDaoHibernate4<Code>
implements CodeDao {
    @Override
    public Code findCodeByPhone(String phone) {
        List<Code> emps = find("select e from Code e where e.phone = ?0"
                , phone);
        if (emps!= null && emps.size() >= 1)
        {
            return emps.get(0);
        }
        return null;
    }
}
