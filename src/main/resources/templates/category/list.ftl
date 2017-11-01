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
                            <th>类目id</th>
                            <th>名字</th>
                            <th>type</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#--类目不需要分页，因此对象不需要加  .content属性  来进行对象字段获取-->
                        <#list categoryList as category>
                        <tr>
                            <td>${category.categoryId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.categoryType}</td>
                            <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>