
    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    drop table Person if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FK6ngo6aym4sgy7da72ucvvf0ia;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FKbgjuv244bwcyudluiw06r8t2c;

    alter table SparePartSpecification_SparePart 
       drop constraint FKlynnfj95wiyo62u2wpdvs4ae3;

    alter table SparePartSpecification_SparePart 
       drop constraint FKo3nb2ie67b13qn4i67fp7esgc;

    drop table Person if exists;

    drop table SparePart if exists;

    drop table SparePartRegister if exists;

    drop table SparePartRegister_SparePartSpecification if exists;

    drop table SparePartSpecification if exists;

    drop table SparePartSpecification_SparePart if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    create table SparePart (
       sparePartId bigint not null,
        sparePartSpecification varbinary(255),
        primary key (sparePartId)
    );

    create table SparePartRegister (
       sparePartRegisterId bigint not null,
        currentSparePartSpec varbinary(255),
        primary key (sparePartRegisterId)
    );

    create table SparePartRegister_SparePartSpecification (
       SparePartRegister_sparePartRegisterId bigint not null,
        sparePartSpecs_spSpecId bigint not null
    );

    create table SparePartSpecification (
       spSpecId bigint not null,
        manufacturer varchar(255),
        manufacturerPartNumber varchar(255),
        partDescription varchar(255),
        partType varchar(255),
        price numeric(19,2),
        primary key (spSpecId)
    );

    create table SparePartSpecification_SparePart (
       SparePartSpecification_spSpecId bigint not null,
        spareParts_sparePartId bigint not null
    );

    alter table SparePartRegister_SparePartSpecification 
       add constraint UK_2a9nfejv7rbphs76nxgyey2tn unique (sparePartSpecs_spSpecId);

    alter table SparePartSpecification_SparePart 
       add constraint UK_8tdhwsql47d4md3ltm2ogarci unique (spareParts_sparePartId);

    alter table SparePartRegister_SparePartSpecification 
       add constraint FK6ngo6aym4sgy7da72ucvvf0ia 
       foreign key (sparePartSpecs_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       add constraint FKbgjuv244bwcyudluiw06r8t2c 
       foreign key (SparePartRegister_sparePartRegisterId) 
       references SparePartRegister;

    alter table SparePartSpecification_SparePart 
       add constraint FKlynnfj95wiyo62u2wpdvs4ae3 
       foreign key (spareParts_sparePartId) 
       references SparePart;

    alter table SparePartSpecification_SparePart 
       add constraint FKo3nb2ie67b13qn4i67fp7esgc 
       foreign key (SparePartSpecification_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FK6ngo6aym4sgy7da72ucvvf0ia;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FKbgjuv244bwcyudluiw06r8t2c;

    alter table SparePartSpecification_SparePart 
       drop constraint FKlynnfj95wiyo62u2wpdvs4ae3;

    alter table SparePartSpecification_SparePart 
       drop constraint FKo3nb2ie67b13qn4i67fp7esgc;

    drop table Person if exists;

    drop table SparePart if exists;

    drop table SparePartRegister if exists;

    drop table SparePartRegister_SparePartSpecification if exists;

    drop table SparePartSpecification if exists;

    drop table SparePartSpecification_SparePart if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    create table SparePart (
       sparePartId bigint not null,
        sparePartSpecification varbinary(255),
        primary key (sparePartId)
    );

    create table SparePartRegister (
       sparePartRegisterId bigint not null,
        currentSparePartSpec varbinary(255),
        primary key (sparePartRegisterId)
    );

    create table SparePartRegister_SparePartSpecification (
       SparePartRegister_sparePartRegisterId bigint not null,
        sparePartSpecs_spSpecId bigint not null
    );

    create table SparePartSpecification (
       spSpecId bigint not null,
        manufacturer varchar(255),
        manufacturerPartNumber varchar(255),
        partDescription varchar(255),
        partType varchar(255),
        price numeric(19,2),
        primary key (spSpecId)
    );

    create table SparePartSpecification_SparePart (
       SparePartSpecification_spSpecId bigint not null,
        spareParts_sparePartId bigint not null
    );

    alter table SparePartRegister_SparePartSpecification 
       add constraint UK_2a9nfejv7rbphs76nxgyey2tn unique (sparePartSpecs_spSpecId);

    alter table SparePartSpecification_SparePart 
       add constraint UK_8tdhwsql47d4md3ltm2ogarci unique (spareParts_sparePartId);

    alter table SparePartRegister_SparePartSpecification 
       add constraint FK6ngo6aym4sgy7da72ucvvf0ia 
       foreign key (sparePartSpecs_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       add constraint FKbgjuv244bwcyudluiw06r8t2c 
       foreign key (SparePartRegister_sparePartRegisterId) 
       references SparePartRegister;

    alter table SparePartSpecification_SparePart 
       add constraint FKlynnfj95wiyo62u2wpdvs4ae3 
       foreign key (spareParts_sparePartId) 
       references SparePart;

    alter table SparePartSpecification_SparePart 
       add constraint FKo3nb2ie67b13qn4i67fp7esgc 
       foreign key (SparePartSpecification_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FK6ngo6aym4sgy7da72ucvvf0ia;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FKbgjuv244bwcyudluiw06r8t2c;

    alter table SparePartSpecification_SparePart 
       drop constraint FKlynnfj95wiyo62u2wpdvs4ae3;

    alter table SparePartSpecification_SparePart 
       drop constraint FKo3nb2ie67b13qn4i67fp7esgc;

    drop table Person if exists;

    drop table SparePart if exists;

    drop table SparePartRegister if exists;

    drop table SparePartRegister_SparePartSpecification if exists;

    drop table SparePartSpecification if exists;

    drop table SparePartSpecification_SparePart if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    create table SparePart (
       sparePartId bigint not null,
        sparePartSpecification varbinary(255),
        primary key (sparePartId)
    );

    create table SparePartRegister (
       sparePartRegisterId bigint not null,
        currentSparePartSpec varbinary(255),
        primary key (sparePartRegisterId)
    );

    create table SparePartRegister_SparePartSpecification (
       SparePartRegister_sparePartRegisterId bigint not null,
        sparePartSpecs_spSpecId bigint not null
    );

    create table SparePartSpecification (
       spSpecId bigint not null,
        manufacturer varchar(255),
        manufacturerPartNumber varchar(255),
        partDescription varchar(255),
        partType varchar(255),
        price numeric(19,2),
        primary key (spSpecId)
    );

    create table SparePartSpecification_SparePart (
       SparePartSpecification_spSpecId bigint not null,
        spareParts_sparePartId bigint not null
    );

    alter table SparePartRegister_SparePartSpecification 
       add constraint UK_2a9nfejv7rbphs76nxgyey2tn unique (sparePartSpecs_spSpecId);

    alter table SparePartSpecification_SparePart 
       add constraint UK_8tdhwsql47d4md3ltm2ogarci unique (spareParts_sparePartId);

    alter table SparePartRegister_SparePartSpecification 
       add constraint FK6ngo6aym4sgy7da72ucvvf0ia 
       foreign key (sparePartSpecs_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       add constraint FKbgjuv244bwcyudluiw06r8t2c 
       foreign key (SparePartRegister_sparePartRegisterId) 
       references SparePartRegister;

    alter table SparePartSpecification_SparePart 
       add constraint FKlynnfj95wiyo62u2wpdvs4ae3 
       foreign key (spareParts_sparePartId) 
       references SparePart;

    alter table SparePartSpecification_SparePart 
       add constraint FKo3nb2ie67b13qn4i67fp7esgc 
       foreign key (SparePartSpecification_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FK6ngo6aym4sgy7da72ucvvf0ia;

    alter table SparePartRegister_SparePartSpecification 
       drop constraint FKbgjuv244bwcyudluiw06r8t2c;

    alter table SparePartSpecification_SparePart 
       drop constraint FKlynnfj95wiyo62u2wpdvs4ae3;

    alter table SparePartSpecification_SparePart 
       drop constraint FKo3nb2ie67b13qn4i67fp7esgc;

    alter table StockReceipt_StockReceiptLineItem 
       drop constraint FKs9o1xmpvn6r1vxmkploekpoq4;

    alter table StockReceipt_StockReceiptLineItem 
       drop constraint FK1nb6hv9ohr8q9ejh2ny4ws7m1;

    drop table Person if exists;

    drop table SparePart if exists;

    drop table SparePartRegister if exists;

    drop table SparePartRegister_SparePartSpecification if exists;

    drop table SparePartSpecification if exists;

    drop table SparePartSpecification_SparePart if exists;

    drop table StockReceipt if exists;

    drop table StockReceipt_StockReceiptLineItem if exists;

    drop table StockReceiptLineItem if exists;

    create table Person (
       personId bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (personId)
    );

    create table SparePart (
       sparePartId bigint not null,
        sparePartSpecification varbinary(255),
        primary key (sparePartId)
    );

    create table SparePartRegister (
       sparePartRegisterId bigint not null,
        currentSparePartSpec varbinary(255),
        primary key (sparePartRegisterId)
    );

    create table SparePartRegister_SparePartSpecification (
       SparePartRegister_sparePartRegisterId bigint not null,
        sparePartSpecs_spSpecId bigint not null
    );

    create table SparePartSpecification (
       spSpecId bigint not null,
        manufacturer varchar(255),
        manufacturerPartNumber varchar(255),
        partDescription varchar(255),
        partType varchar(255),
        price numeric(19,2),
        primary key (spSpecId)
    );

    create table SparePartSpecification_SparePart (
       SparePartSpecification_spSpecId bigint not null,
        spareParts_sparePartId bigint not null
    );

    create table StockReceipt (
       stockReceiptId bigint not null,
        comments varchar(255),
        receiptDate timestamp,
        status varchar(255),
        stockReceiptLineItem varbinary(255),
        totalQuantity integer not null,
        primary key (stockReceiptId)
    );

    create table StockReceipt_StockReceiptLineItem (
       StockReceipt_stockReceiptId bigint not null,
        stockReceiptLineItems_stockReceiptLineItemId bigint not null
    );

    create table StockReceiptLineItem (
       stockReceiptLineItemId bigint not null,
        comments varchar(255),
        poNumber varchar(255),
        quantity integer not null,
        sparePart varbinary(255),
        sparePartId bigint,
        sparePartSpecification varbinary(255),
        store varbinary(255),
        primary key (stockReceiptLineItemId)
    );

    alter table SparePartRegister_SparePartSpecification 
       add constraint UK_2a9nfejv7rbphs76nxgyey2tn unique (sparePartSpecs_spSpecId);

    alter table SparePartSpecification_SparePart 
       add constraint UK_8tdhwsql47d4md3ltm2ogarci unique (spareParts_sparePartId);

    alter table StockReceipt_StockReceiptLineItem 
       add constraint UK_94rd3oumuno6bnftm0t65qc20 unique (stockReceiptLineItems_stockReceiptLineItemId);

    alter table SparePartRegister_SparePartSpecification 
       add constraint FK6ngo6aym4sgy7da72ucvvf0ia 
       foreign key (sparePartSpecs_spSpecId) 
       references SparePartSpecification;

    alter table SparePartRegister_SparePartSpecification 
       add constraint FKbgjuv244bwcyudluiw06r8t2c 
       foreign key (SparePartRegister_sparePartRegisterId) 
       references SparePartRegister;

    alter table SparePartSpecification_SparePart 
       add constraint FKlynnfj95wiyo62u2wpdvs4ae3 
       foreign key (spareParts_sparePartId) 
       references SparePart;

    alter table SparePartSpecification_SparePart 
       add constraint FKo3nb2ie67b13qn4i67fp7esgc 
       foreign key (SparePartSpecification_spSpecId) 
       references SparePartSpecification;

    alter table StockReceipt_StockReceiptLineItem 
       add constraint FKs9o1xmpvn6r1vxmkploekpoq4 
       foreign key (stockReceiptLineItems_stockReceiptLineItemId) 
       references StockReceiptLineItem;

    alter table StockReceipt_StockReceiptLineItem 
       add constraint FK1nb6hv9ohr8q9ejh2ny4ws7m1 
       foreign key (StockReceipt_stockReceiptId) 
       references StockReceipt;
