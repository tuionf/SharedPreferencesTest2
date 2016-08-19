# SharedPreferencesTest2
该项目融合了第一行代码中的SharedPreferencesTest 以及后续的记住密码登陆的功能

# 登陆
![1](https://github.com/tuionf/SharedPreferencesTest2/blob/master/art/1.png)

#笔记

SharedPreferences存储

获取SharedPreferences对象的三种办法
       第一种 context 的getSharedPreferences方法 (文件名，操作模式)
        mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        MODE_PRIVATE 表示只有当前的应用程序才可以读写该文件
        第二种  Activity 的 getPreferences(MODE_PRIVATE)
        第三种  PreferenceManager.getDefaultSharedPreferences(context)
        
SharedPreferences存储的方法和步骤
1. 获取SharedPreferences对象
2. 利用SharedPreferences的edit()方法获取SharedPreferences.Editor对象
3. 向SharedPreferences.Editor对象中添加数据，利用 putString() putInt() 等方法
4. 调用commit()方法提交 

相应的获取其存储文件的数据类似

账号密码分别是 tuionf@163.com    123456

# 点击保存数据

会保存SharedPreferences文件，并弹出Toast
![2](https://github.com/tuionf/SharedPreferencesTest2/blob/master/art/2.png)

# 恢复数据
点击后，会在上面的EditText上显示出来SharedPreferences文件中保存的数据
![3](https://github.com/tuionf/SharedPreferencesTest2/blob/master/art/3.png)
![4](https://github.com/tuionf/SharedPreferencesTest2/blob/master/art/4.png)
