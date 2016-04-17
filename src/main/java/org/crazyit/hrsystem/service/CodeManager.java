package org.crazyit.hrsystem.service;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.domain.Code;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public interface CodeManager {
    Code findCodeByPhone(String phone);
    boolean saveCode(Code code);
}
