package org.crazyit.hrsystem.service.impl;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.dao.*;
import org.crazyit.hrsystem.domain.Code;
import org.crazyit.hrsystem.service.CodeManager;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public class CodeManagerImpl implements CodeManager {
    private AdminaterDao adminaterDao;
    private DriverDao driverDao;
    private UsernameDao usernameDao;
    private DriverCommentsDao driverCommentsDao;
    private CodeDao codeDao;

    public void setCodeDao(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public void setDriverCommentsDao(DriverCommentsDao driverCommentsDao) {
        this.driverCommentsDao = driverCommentsDao;
    }

    public void setAdminaterDao(AdminaterDao adminaterDao) {
        this.adminaterDao = adminaterDao;
    }

    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    public void setUsernameDao(UsernameDao usernameDao) {
        this.usernameDao = usernameDao;
    }

    @Override
    public Code findCodeByPhone(String phone) {
        return codeDao.findCodeByPhone(phone);
    }

    @Override
    public boolean saveCode(Code code) {
        codeDao.save(code);
        return true;
    }
}
