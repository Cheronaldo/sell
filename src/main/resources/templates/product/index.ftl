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
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid"> <!--fluid表示样式流动布局 自适应-->
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" type="text" class="form-control"  value="${(productInfo.productName)!''}"/>
                            <#--对象为空处理  (productInfo.productName)!''  加 ！"" 也可以-->
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control"  value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="number" class="form-control"  value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control"  value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control"  value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#--freemarker中是否存在的 判断是 ??-->
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                        >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
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