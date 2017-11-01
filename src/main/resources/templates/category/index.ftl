<html>

<#include "../common/header.ftl">

<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--注意内容区-->
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid"> <!--fluid表示样式流动布局 自适应-->
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="categoryName" type="text" class="form-control"  value="${(category.categoryName)!''}"/>
                            <#--对象为空处理  (productInfo.productName)!''  加 ！"" 也可以-->
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control"  value="${(category.categoryType)!''}"/>
                        </div>

                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <#--添加隐藏属性 productId 方便表单提交后的对象保存-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>