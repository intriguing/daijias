package org.crazyit.hrsystem.dao.impl;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.DriverCommentsDao;
import org.crazyit.hrsystem.domain.DriverComments;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public class DriverCommentsDaoHibernate4 extends BaseDaoHibernate4<DriverComments>
implements DriverCommentsDao {
    @Override
    public List<DriverComments> findDriverCommentsById(String driverId) {
        return find("select p from DriverComments p where p.driverId = ?0"
                , driverId);
    }
}
