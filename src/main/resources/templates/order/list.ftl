<html>
    <head>
        <meta charset="UTF-8">
        <title>卖家商品列表</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>订单Id</th>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>地址</th>
                        <th>金额</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list content as cont>
                        <tr class="success">
                            <td>${cont.orderId}</td>
                            <td>${cont.buyerName}</td>
                            <td>${cont.buyerPhone}</td>
                            <td>${cont.buyerAddress}</td>

                            <td>${cont.orderAmount}</td>
                            <td>${cont.getOrderStatusEnum().msg}</td>
                            <td>${cont.getPayStatusEnum().msg}</td>
                            <td>${cont.createTime}</td>
                            <td>
                                <a href="/seller/order/detail?orderId=${cont.orderId}">详情</a>

                            </td>
                            <td>
                                <#if cont.getOrderStatusEnum().msg !="已取消">
                                    <a href="/seller/order/cancel?orderId=${cont.orderId}">取消</a>
                                </#if>
                            </td>
                        </tr>
                    </#list>


                    </tbody>
                </table>
            </div>
        </div>
    </div>

    </body>
</html>

<#--<h1>${orderDTOPage.getTotalPages()}</h1>-->
<#--<h1>${orderDTOPage.totalPages}</h1>-->

<#--<#list content as cont>-->
    <#--${cont.orderId}-->
<#--</#list>-->