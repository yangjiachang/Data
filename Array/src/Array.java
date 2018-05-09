/**
 * @Author: 杨佳畅
 * @Description: 自定义的Array类
 * @Date: Created in 2018/5/2 下午10:13
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
    * @Author: 杨佳畅
    * @Description: 构造函数,传入数组的容量capacity构造Array
    * @Date: Created in 2018/5/2 下午10:16
    * @param: 数组的容量
    */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    
    /**
    * @Author: 杨佳畅
    * @Description: 无参数的构造函数,默认数组的容量为10
    * @Date: Created in 2018/5/2 下午10:17
    * @param: null
    */
    public Array(){
        //调用有参的构造函数
        this(10);
    }

    /**
    * @Author: 杨佳畅
    * @Description: 获取数组中的元素个数
    * @Date: Created in 2018/5/2 下午10:20
    * @param: null
    */
    public int getSize(){
        return size;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 获取数组容量
    * @Date: Created in 2018/5/2 下午10:22
    * @param: null
    */
    public int getCapacity(){
        return data.length;
    }
    
    /**
    * @Author: 杨佳畅
    * @Description: 返回数组是否为空
    * @Date: Created in 2018/5/2 下午10:22
    * @param: null
    */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 在数组元素后添加一个新元素
    * @Date: Created in 2018/5/2 下午10:23
    * @param: 要添加的元素
    */
    public void addLast(E e){
        //判断数组是否有足够的空间
//        if(size == data.length)
//            throw new IllegalArgumentException("AddList -> 添加元素失败");
//        data[size] = e;
//        size++;
        //直接调用添加方法
        add(size,e);
    }

    /**
    * @Author: 杨佳畅
    * @Description: 在数组元素前添加一个新元素
    * @Date: Created in 2018/5/2 下午10:41
    * @param: 要添加的元素
    */
    public void addFirst(E e){
        add(0,e);
    }

    /**
    * @Author: 杨佳畅
    * @Description: 在数组中第index的位置插入元素e
    * @Date: Created in 2018/5/2 下午10:33
    * @param: null
    */
    public void add(int index,E e){
        //判断数组是否有足够的空间
//        if(size == data.length)
//            throw new IllegalArgumentException("Add -> 添加元素失败");
        if(index < 0 && index > size)
            throw new IllegalArgumentException("Add -> 添加元素失败 where index >= 0 and index <= size");

        if(size == data.length)
            resize(2 * data.length); //数组扩容

        for(int i = size - 1 ;  i >= index ; i -- )
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }



    /**
    * @Author: 杨佳畅
    * @Description: 获取index位置的元素
    * @Date: Created in 2018/5/3 上午9:13
    * @param: 索引
    */
    E get(int index){
        if(index < 0 && index >= size)
            throw new IllegalArgumentException("Get : 索引错误");
        return data[index];
    }

    /**
    * @Author: 杨佳畅
    * @Description: 修改index位置的元素为e
    * @Date: Created in 2018/5/3 上午9:14
    * @param: null
    */
    void set(int index , E e){
        if(index < 0 && index >= size)
            throw new IllegalArgumentException("Set : 索引错误");
        data[index] = e;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 查找数组中是否有元素e
    * @Date: Created in 2018/5/3 上午9:18
    * @param: 查找的元素
    */
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 查找数组中元素e所在的索引 , 如果元素中不存在e 则返回 -1
    * @Date: Created in 2018/5/3 上午9:19
    * @param: 查找的元素
    */
    public int find(int e){
        for(int i= 0 ; i < size ; i ++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 从数组中删除index位置的元素, 返回删除的元素
    * @Date: Created in 2018/5/3 上午9:25
    * @param: null
    */
    public E remove(int index){
        if(index < 0 && index >= size)
            throw new IllegalArgumentException("Remove : 索引错误");
        E res = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null; // 清空这个元素的引用
        //缩容
        if(size == data.length / 2)
            resize(data.length / 2);
        return res;
    }

    /**
    * @Author: 杨佳畅
    * @Description: 删除数组中第一个元素
    * @Date: Created in 2018/5/3 上午9:31
    * @param: null
    */
    public E removeFirst(){
        return remove(0);
    }

    /**
    * @Author: 杨佳畅
    * @Description: 删除数组中最后一个元素
    * @Date: Created in 2018/5/3 上午9:32
    * @param: null
    */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
    * @Author: 杨佳畅
    * @Description: 删除数组中为e的元素
    * @Date: Created in 2018/5/3 上午9:33
    * @param: null
    */
    public void removeElement(int e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d\n", size , data.length));
        res.append("[ ");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(" ]");
        return res.toString();
    }

    /**
     * @Author: 杨佳畅
     * @Description: 数组扩容
     * @Date: Created in 2018/5/3 上午10:09
     * @param: null
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;

    }








}
