package com.cmartus.contactsprojects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "contacts")
class Contact {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String? = null

    constructor() { }

    constructor(id: Int, productname: String, phonenumber: String) {
        this.contactName = productname
        this.phoneNumber = phonenumber
    }
    constructor(contactname: String, phonenumber: String){
        this.contactName = contactname
        this.phoneNumber = phonenumber
    }
}