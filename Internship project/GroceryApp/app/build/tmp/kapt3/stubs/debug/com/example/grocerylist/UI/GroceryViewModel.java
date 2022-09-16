package com.example.grocerylist.UI;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/grocerylist/UI/GroceryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/grocerylist/Database/GroceryRepository;", "(Lcom/example/grocerylist/Database/GroceryRepository;)V", "allGroceryItems", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/grocerylist/Database/Entity/GroceryItems;", "delete", "Lkotlinx/coroutines/Job;", "item", "insert", "app_debug"})
public final class GroceryViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.grocerylist.Database.GroceryRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.Entity.GroceryItems item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.Entity.GroceryItems item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.grocerylist.Database.Entity.GroceryItems>> allGroceryItems() {
        return null;
    }
    
    public GroceryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Database.GroceryRepository repository) {
        super();
    }
}