<#--<h1>${orderDTOPage.getTotalPages()}</h1>-->
<#--<h1>${orderDTOPage.totalPages}</h1>-->
<!--渲染对象的属性直接调用，渲染对象的方法时注意加上小括号-->

<html>

<#include "../common/header.ftl">

<body>
<#--注意class的命名要与css样式中一致 -->
<div id="wrapper" class="toggled">
        <#--边栏sidebar   引入共用的标签  “../” 表示上一级目录-->
        <#include "../common/nav.ftl">

        <#--注意内容区-->
        <div id="page-content-wrapper">
            <div class="container-fluid"> <!--fluid表示样式流动布局 自适应-->
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-hover table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                            <#--<th>创建时间</th>-->
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAddress}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.getOrderStatusEnum().message}</td>
                                <td>${orderDTO.getPayStatusEnum().message}</td>
                            <#--<td>${orderDTO.createTime}</td>-->
                                <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                                <td>
                                    <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                        <!--注意不要写成 sell/seller/order/cancel 这样会在原来的url后面加上这一段再进行跳转-->
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <!--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <!--currentPage lte 1就是<=1-->
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                            <!--1..<orderDTOPage.getTotalPages()  显示的是从第二页到倒数第二页-->
                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>

                        </ul>
                    </div>
                </div>

            </div>
        </div>
</div>

<#--新订单弹窗提示  websocket机制-->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒！
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单!!!
            </div>
            <div class="modal-footer">
                <#--bootstrap里面已经将遮罩窗体的关闭功能写到，关闭按钮中，不需要再对关闭窗体声明其他的函数-->
                <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>
    </div>
</div>

<#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
</audio>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>

    var websocket = null;
    //判断浏览器是否支持 WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket('ws://127.0.0.1:8080/sell/webSocket');
        //注意填写域名和ip的区别，填ip的时候要加上 端口号 走的是 ws 协议
        //可以将域名映射为对的ip和端口号
    }else {
        alert('该浏览器不支持WebSocket！');
    }
    
    websocket.onopen = function (event) {
        console.log('建立连接');
    }

    websocket.onclose = function (event) {
        console.log('连接关闭');
    }

    websocket.onmessage = function (event) {
        console.log('收到消息：'+event.data);
        //弹窗提醒，播放音乐
        //弹窗
        $('#myModal').modal('show');
        //播放音乐
        document.getElementById('notice').play();

    }

    websocket.onerror = function (event) {
        alert('WebSocket通信发生错误！');
    }

    //在窗口关闭之前，要把websoket关闭
    window.onbeforeunload = function (event) {
        websocket.close();
    }


</script>

</body>
</html>