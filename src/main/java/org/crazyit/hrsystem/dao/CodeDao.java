package org.crazyit.hrsystem.dao;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.Code;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public interface CodeDao extends BaseDao<Code> {
    Code findCodeByPhone(String phone);
}
