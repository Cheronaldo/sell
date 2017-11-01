<#--<h1>${orderDTOPage.getTotalPages()}</h1>-->
<#--<h1>${orderDTOPage.totalPages}</h1>-->
<!--渲染对象的属性直接调用，渲染对象的方法时注意加上小括号-->

<html>

<#include "../common/header.ftl">

<body>

    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

        <#--注意内容区-->
        <div id="page-content-wrapper">
            <div class="container-fluid"> <!--fluid表示样式流动布局 自适应-->
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-hover table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>名称</th>
                                <th>图片</th>
                                <th>单价</th>
                                <th>库存</th>
                                <th>描述</th>
                                <th>类目</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                            <#--<td>${orderDTO.createTime}</td>-->
                                <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().message == "在架">
                                        <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                        <!--注意不要写成 sell/seller/order/cancel 这样会在原来的url后面加上这一段再进行跳转-->
                                    <#else >
                                        <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
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
                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte productInfoPage.getTotalPages()>
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

    </body>
</html>