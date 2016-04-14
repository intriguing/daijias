package org.crazyit.hrsystem.service;
/**
 * Creation Date:${date}-${time}
 * <p>
 * Copyright 2008-${year}  Inc. All Rights Reserved
 */

import org.crazyit.hrsystem.domain.DriverComments;
import org.crazyit.hrsystem.vo.CommentVo;

import java.util.List;

/**
 * Description Of The Class<br/>
 * QQ:1226109187
 *
 * @author (周天晓 25059)
 * @version 1.0.0, ${date}-${time}
 * @since ${date}-${time}
 */
public interface DriverCommentsManager {
    boolean saveUsername(DriverComments driverComments);
    List<CommentVo>  findCommentVoById(String driverId);
}
