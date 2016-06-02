<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/31 0031
  Time: 下午 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--样式 Begin--%>
    <style>
        body{text-align:center}
        .divcss5{margin:0 auto;width:400px;border:1px solid #000}
        /* CSS注释：设置对象边框、宽度、高度 便于观察布局效果 */

        TD {
            FONT-SIZE: 25px; COLOR: #ffffff; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }
    </style>
    <%--样式 End--%>

    <%--js Begin--%>
    <SCRIPT language=JavaScript>
        function tick() {
            var years,months,days,hours, minutes, seconds;
            var intYears,intMonths,intDays,intHours, intMinutes, intSeconds;
            var today;
            today = new Date(); //系统当前时间
            intYears = today.getFullYear(); //得到年份,getFullYear()比getYear()更普适
            intMonths = today.getMonth() + 1; //得到月份，要加1
            intDays = today.getDate(); //得到日期
            intHours = today.getHours(); //得到小时
            intMinutes = today.getMinutes(); //得到分钟
            intSeconds = today.getSeconds(); //得到秒钟
            years = intYears + "-";
            if(intMonths < 10 ){
                months = "0" + intMonths +"-";
            } else {
                months = intMonths +"-";
            }
            if(intDays < 10 ){
                days = "0" + intDays +" ";
            } else {
                days = intDays + " ";
            }
            if (intHours == 0) {
                hours = "00:";
            } else if (intHours < 10) {
                hours = "0" + intHours+":";
            } else {
                hours = intHours + ":";
            }
            if (intMinutes < 10) {
                minutes = "0"+intMinutes+":";
            } else {
                minutes = intMinutes+":";
            }
            if (intSeconds < 10) {
                seconds = "0"+intSeconds+" ";
            } else {
                seconds = intSeconds+" ";
            }
            timeString = years+months+days+hours+minutes+seconds;
            Clock.innerHTML = timeString;
            window.setTimeout("tick();", 1000);
        }
        window.onload = tick;
    </SCRIPT>
    <%--js End--%>

</head>
<body>
    <div id="信息录入" class = "div">

        <%--time Begin--%>
            <TABLE cellSpacing=0 cellPadding=0 width="630px" border=0>
                <TR bgColor=#73a3d4 height=40>
                    <TD noWrap align=center width=400px ><SPAN id="Clock" name="blog.publishTime"></SPAN></TD>
                </TR>
            </TABLE>
        <%--time End--%>

        <fieldset style="width:25%;border-color:#FF0000">
            <legend>电影信息录入</legend>
            <form action="/Blog/blogadd" method="post">
                <p><label>标题：</label><input type="text" name="blog.title"></p>
                <p><label>内容如下<small>【温馨提示:暂不支持表情插入】</small></label></p>
                <textarea style="width: 600px;height: 200px;" name="blog.content"></textarea>
                <br/><br/>
                <input type="submit" value="提交">
            </form>
        </fieldset>
    </div>





</body>
</html>
