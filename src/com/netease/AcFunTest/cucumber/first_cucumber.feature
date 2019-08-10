#language:zh-CN
功能:163登录功能
  @Automation @p0
  场景:测试正确的账号登录
    当我打开163网站
    并且我在email文件框输入"meyoungtester"
    并且我在密码框输入"meyoung123"
    当我点击登录按钮
    那么我登录成功

   场景: 邮箱登录功能2
     当我打开"http://mail.163.com"页面
     而且我输入账号"meyoungtester1",密码"meoung1231"
     而且我点击记住密码
     当我点击登录按钮
     那么我登录成功

    场景:邮箱登录功能失败
      当我打开"http://mail.163.com"页面
      而且我输入账号"meyoungtester1",密码"meoung1213"
      当我点击登录按钮
      那么我登录失败

    场景: 邮箱登录功能2
      当我打开"http://mail.163.com"页面
      而且我输入账号"fasdfa",密码"fasfda"
      当我点击登录按钮
      那么我登录失败
#
#  场景大纲: 登录2
#    当我打开163网站
#    当我在email文本框输入"<username>"
#    而且我在密码框输入"<pwd>"
#    那么我登录成功
  @p2
  场景大纲: 测试正确的账号登录2
    假如我打开163网站
    假如我用"<email>"账号,密码"<pwd>"登录
    那么我登录成功
    例子:
    |username|pwd|
    |test1|pwd1|
    |test2|pwd2|

   场景: 网站
     当我打开163网站