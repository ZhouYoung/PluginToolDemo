# PluginToolDemo
Intellij IDEA 上自定义插件 
> 工作中往往会出现很多需要小工具、最近接触的IDEA、发现里面很多插件很顺手、就像这把工作中很常见的一些工具移植到IDEA上。

# 教程目标
- 本次教程、只是简单教会大家如何在IDEA上搭建自己的插件，即在IDEA按下某个快捷键、弹出我们的工具对话框。

# 教程硬件环境
- IntelliJ IDEA 2016.1.2
- jdk8

# 正式开始

## 新建项目
>  ![新建插件](http://upload-images.jianshu.io/upload_images/3007484-83def7382d26c52b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 项目命名
>  ![项目命名](http://upload-images.jianshu.io/upload_images/3007484-e36955748682833a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 新建一个Action
>  ![新建一个Action](http://upload-images.jianshu.io/upload_images/3007484-df1186cdca4bae92.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 配置Action
>  ![配置Action](http://upload-images.jianshu.io/upload_images/3007484-fe95b3038ea1314b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 新建一个Dialog
>  ![新建一个Dialog](http://upload-images.jianshu.io/upload_images/3007484-1049b1cf70fbad5e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 完善Dialog
>  由于IDEA含有对Swing 的界面操作、有.net基础看到估计很亲切、直接拖JTextArea控件到面板上
![](http://upload-images.jianshu.io/upload_images/3007484-35737e236dc3e364.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 代码编写-修改PluginToolDemoDialog
> 我们期望在输入框中输入字符串、点击ok键弹出刚才输入的内容
 

```
public class PluginToolDemoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    public PluginToolDemoDialog() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        setSize(800,400);
        setLocationRelativeTo(null);
        setModal(false);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    private void onOK() {

        JOptionPane.showMessageDialog(this,  textArea1.getText());
    }
    private void onCancel() {

        dispose();
    }
    public static void main(String[] args) {
        PluginToolDemoDialog dialog = new PluginToolDemoDialog();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(800,400);
    }
}
```

## Action 添加下面内容

```
public class PluginToolDemo extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        PluginToolDemoDialog dialog = new PluginToolDemoDialog();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(800,400);
    }
}
```
## 修改plugin.xml
> 
![](http://upload-images.jianshu.io/upload_images/3007484-826301a3687d4708.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 编译生产插件
> 
![图片.png](http://upload-images.jianshu.io/upload_images/3007484-85546fec99492449.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 加载新开发的插件
> *[File]->[Setting]-[Plugins]*
![加载插件](http://upload-images.jianshu.io/upload_images/3007484-c3c45842c9b5ffab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 重启IDEA
> *按下【ALT+E】试试吧！！*

![](http://upload-images.jianshu.io/upload_images/3007484-b9c05c15c31c10c3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


# 结束
> 以上有问题，欢迎留言
[git源码包](https://github.com/ZhouYoung/PluginToolDemo)
