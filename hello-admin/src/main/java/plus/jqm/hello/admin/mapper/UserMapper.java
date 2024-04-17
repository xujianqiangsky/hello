package plus.jqm.hello.admin.mapper;

import org.apache.ibatis.annotations.Param;
import plus.jqm.hello.admin.domain.UserDO;

/**
 * User Mapper
 *
 * @author xjq
 * @date 2024/04/16
 */
public interface UserMapper {
    UserDO getUserById(@Param("id") long id);

    UserDO getUserByUsername(@Param("username") String username);
}
