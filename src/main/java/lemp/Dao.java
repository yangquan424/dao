package lemp;

import java.util.List;

/**
 * 顶层接口
 * @param <T> 数据对象名称
 * @param <K> 数据主键名称类型
 */
public interface Dao<T,K> {
    /**
     * 实现数据的增加操作
     * @param vo 包含了要添加的vo对象
     * @return 返回受影响的行数
     */
    public int doCreate(T vo);

    /*
     * 实现数据的修改操作
     * @param vo 包含了要修改数据的信息，一定要提供有ID内容
     * @return 返回受影响的行数
     * */
    public int doUpdate(T vo);

    /**
     * 实现数据的删除
     * @param id 要删除对象的主键
     * @return 返回受影响的行数
     */
    public int doDelete(K id);

    /**
     * 查询所有数据
     * @return 返回数据集合
     */
    public List<T> findAll();

    /**
     * 查询一条数据
     * @param id 被查询对象的主键
     * @return 返回被查询的数据
     */
    public T findById(K id);

}
