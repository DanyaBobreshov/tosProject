<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">ОВУ</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Наименование</th>
                </tr>
                <#list invoices as invoice>
                <tr>
                    <th>${invoice.id}</th>
                    <th>${invoice.title}</th>
                </tr>
                <#else>
                <h3>Актов нет</h3>
            </#list>
            </table>
    <hr>
    </@t.template>