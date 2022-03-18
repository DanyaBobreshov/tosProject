<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template invoice>
    <hr>
        <form action="invoice-edit/${invoice.id}" method="post">
            <div class="form-group">
                <label for="invoiceTitle">Наименование</label>
                <input type="text" value="${invoice.title}" required class="form-control"
                       id="invoiceTitle" name="invoiceTitle">
            </div>
            <div class="form-group">
         <label for="dateOfCreate">Дата создания</label>
          <input type="date" value="${invoice.dateOfCreate}" required class="form-control"
           id="dateOfCreate" name="dateOfCreate">
            </div>
                <div class="form-group">
             <label for="dateOfPerformed">Дата создания</label>
              <input type="date" value="${invoice.dateOfPerformed}" required class="form-control"
               id="dateOfPerformed" name="dateOfPerformed">
                </div>
                <div class="form-group">
                 <label for="dateOfOut">Действителен до</label>
                  <input type="date" value="${invoice.dateOfOut}" required class="form-control"
                   id="dateOfOut" name="dateOfOut">
                    </div>
             <div class="form-group">
                            <label for="invoiceRegimentIn">Получатель</label>
                            <input type="text"  value="${invoice.regimentIn.title}" required class="form-control"
                                   id="invoiceRegimentIn" name="invoiceRegimentIn">
                        </div>
              <div class="form-group">
                             <label for="{invoiceTransfer">Транспорт</label>
                             <input type="text" value="${invoice.transfer.title}" required class="form-control"
                                    id="invoiceTransfer" name="invoiceTransfer">
                         </div>
              <div class="form-group">
                             <label for="invoicePerformerOne">Первый исполнитель</label>
                             <input type="text" value="${invoice.performerOne.name}" required class="form-control"
                                    id="invoicePerformerOne" name="invoicePerformerOne">
                         </div>
             <div class="form-group">
                             <label for="invoicePerformerTho">Второй исполнитель</label>
                             <input type="text" value="${invoice.performerTho.name}" required class="form-control"
                                    id="invoicePerformerTho" name="invoicePerformerTho">
                         </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>