<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">НАРЯДЫ</h1><hr>
    <hr>
        <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
           data-toggle="collapse" href="#collapseExample" role="button"
           aria-expanded="true" aria-controls="collapseExample">
            Добавить новый наряд
        </a>
        <div class="collapse mb-3" id="collapseExample" style="">
            <form action="/invoice/add" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="invoiceTitle">Номер наряда</label>
                    <input type="text" required class="form-control"
                           id="invoiceTitle" name="invoiceTitle">
                </div>
                 <div class="form-group">
                                <label for="invoiceRegimentIn">Получатель</label>
                                <input type="text" required class="form-control"
                                       id="invoiceRegimentIn" name="invoiceRegimentIn">
                            </div>
                  <div class="form-group">
                                 <label for="{invoiceTransfer">Транспорт</label>
                                 <input type="text" required class="form-control"
                                        id="invoiceTransfer" name="invoiceTransfer">
                             </div>
                  <div class="form-group">
                                 <label for="invoicePerformerOne">Первый исполнитель</label>
                                 <input type="text" required class="form-control"
                                        id="invoicePerformerOne" name="invoicePerformerOne">
                             </div>
                 <div class="form-group">
                                 <label for="invoicePerformerTho">Второй исполнитель</label>
                                 <input type="text" required class="form-control"
                                        id="invoicePerformerTho" name="invoicePerformerTho">
                             </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>
    </div>
    </hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Номер наряда</th>
                    <th scope="col">Дата создания</th>
                    <th scope="col">Дата исполнения</th>
                    <th scope="col">Действителен до</th>
                    <th scope="col">Получатель</th>
                    <th scope="col">Транспорт</th>
                    <th scope="col">Первый исполнитель</th>
                    <th scope="col">Второй исполнитель</th>
                    <th scope="col">Изделия</th>
                    <th scope="col">ИСПОЛНЕН</th>
                    <th scope="col">Редактирование</th>
                    <th scope="col">Удаление</th>
                </tr>
                <#list invoices as invoice>
                <tr>
                    <th>${invoice.id}</th>
                    <th>${invoice.title}</th>
                    <th>${invoice.dateOfCreate}</th>
                    <th>${invoice.dateOfPerformed}</th>
                    <th>${invoice.dateOfOut}</th>
                    <th>${invoice.regimentIn.title}</th>
                    <th>${invoice.transfer.title}</th>
                    <th>${invoice.performerOne.name}</th>
                    <th>${invoice.performerTho.name}</th>
                    <th><a href="/invoice/products/${invoice.id}">Изделия</a></th>
                <th>
                    <form action="/invoice/ban/${invoice.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="ИСПОЛНЕН">
                    </form>
                </th>
                    <th><a href="/invoice/edit/${invoice.id}">Редактировние</a></th>
                    <th><a href="/invoice/delete/${invoice.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Нарядов нет</h3>
            </#list>
            </table>

    <form method="get" action="/invoices">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по нарядам</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новый наряд
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/invoice/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="invoiceTitle">Номер наряда</label>
                <input type="text" required class="form-control"
                       id="invoiceTitle" name="invoiceTitle">
            </div>
             <div class="form-group">
                            <label for="invoiceRegimentIn">Получатель</label>
                            <input type="text" required class="form-control"
                                   id="invoiceRegimentIn" name="invoiceRegimentIn">
                        </div>
              <div class="form-group">
                             <label for="{invoiceTransfer">Транспорт</label>
                             <input type="text" required class="form-control"
                                    id="invoiceTransfer" name="invoiceTransfer">
                         </div>
              <div class="form-group">
                             <label for="invoicePerformerOne">Первый исполнитель</label>
                             <input type="text" required class="form-control"
                                    id="invoicePerformerOne" name="invoicePerformerOne">
                         </div>
             <div class="form-group">
                             <label for="invoicePerformerTho">Второй исполнитель</label>
                             <input type="text" required class="form-control"
                                    id="invoicePerformerTho" name="invoicePerformerTho">
                         </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
</form>
</div>
   </@t.template>