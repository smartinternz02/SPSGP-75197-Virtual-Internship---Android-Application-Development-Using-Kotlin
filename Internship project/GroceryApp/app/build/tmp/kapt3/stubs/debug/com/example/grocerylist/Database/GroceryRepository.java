package com.example.grocerylist.Database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/grocerylist/Database/GroceryRepository;", "", "db", "Lcom/example/grocerylist/Database/GroceryDatabase;", "(Lcom/example/grocerylist/Database/GroceryDatabase;)V", "allGroceryItems", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/grocerylist/Database/Entity/GroceryItems;", "delete", "", "item", "(Lcom/example/grocerylist/Database/Entity/GroceryItems;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
public final class GroceryRepository {
    private final com.example.grocerylist.Database.GroceryDatabase db = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.Entity.GroceryItems item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.Entity.GroceryItems item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.grocerylist.Database.Entity.GroceryItems>> allGroceryItems() {
        return null;
    }
    
    public GroceryRepository(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.GroceryDatabase db) {
        super();
    }
}