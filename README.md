# CommonListView
通用的ListView组件

ListView组件常见的两个问题以及解决方法：

1. ListView中添加抢夺焦点的组件（CheckBox、Button等），ListView的Item会无法点击。

  解决方法：
  
  -1.在布局文件的CheckBox中添加属性```xml android:focusable="false" ```
  
  -2.在CheckBox的父布局中添加```xml android:descendantFocusability="blocksDescendants" ```以阻止焦点往子组件的传递
  
2. convertView复用引起的一屏之外的CheckBox选中的问题。
  解决方法：
  
  -1.在Bean中添加一个是否选中的变量值，添加get和set方法，然后在继承的Adapter中的convert方法中
  
  ```java  
        cb.setChecked(bean.isChecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(cb.isChecked());
            }
        });
        ```
        
  -2.在Adapter中添加一个List存储CHeckBox是否选中
