package com.example.grocerylist.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/grocerylist/Adapter/GroceryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/grocerylist/Adapter/GroceryAdapter$GroceryViewHolder;", "list", "", "Lcom/example/grocerylist/Database/Entity/GroceryItems;", "viewModel", "Lcom/example/grocerylist/UI/GroceryViewModel;", "(Ljava/util/List;Lcom/example/grocerylist/UI/GroceryViewModel;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getViewModel", "()Lcom/example/grocerylist/UI/GroceryViewModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GroceryViewHolder", "app_debug"})
public final class GroceryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.grocerylist.Adapter.GroceryAdapter.GroceryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.grocerylist.Database.Entity.GroceryItems> list;
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerylist.UI.GroceryViewModel viewModel = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.grocerylist.Adapter.GroceryAdapter.GroceryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.grocerylist.Adapter.GroceryAdapter.GroceryViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.grocerylist.Database.Entity.GroceryItems> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.grocerylist.Database.Entity.GroceryItems> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerylist.UI.GroceryViewModel getViewModel() {
        return null;
    }
    
    public GroceryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.grocerylist.Database.Entity.GroceryItems> list, @org.jetbrains.annotations.NotNull()
    com.example.grocerylist.UI.GroceryViewModel viewModel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/grocerylist/Adapter/GroceryAdapter$GroceryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/grocerylist/Adapter/GroceryAdapter;Landroid/view/View;)V", "app_debug"})
    public final class GroceryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public GroceryViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}