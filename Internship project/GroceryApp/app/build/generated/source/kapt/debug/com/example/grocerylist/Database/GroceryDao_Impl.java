package com.example.grocerylist.Database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.grocerylist.Database.Entity.GroceryItems;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GroceryDao_Impl implements GroceryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GroceryItems> __insertionAdapterOfGroceryItems;

  private final EntityDeletionOrUpdateAdapter<GroceryItems> __deletionAdapterOfGroceryItems;

  public GroceryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGroceryItems = new EntityInsertionAdapter<GroceryItems>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `grocery_items` (`id`,`itemName`,`itemQuantity`,`itemPrice`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GroceryItems value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemName());
        }
        stmt.bindLong(3, value.getItemQuantity());
        stmt.bindLong(4, value.getItemPrice());
      }
    };
    this.__deletionAdapterOfGroceryItems = new EntityDeletionOrUpdateAdapter<GroceryItems>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `grocery_items` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GroceryItems value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final GroceryItems item, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGroceryItems.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final GroceryItems item, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGroceryItems.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<GroceryItems>> getAllGroceryItems() {
    final String _sql = "SELECT * FROM grocery_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"grocery_items"}, false, new Callable<List<GroceryItems>>() {
      @Override
      public List<GroceryItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfItemQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "itemQuantity");
          final int _cursorIndexOfItemPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "itemPrice");
          final List<GroceryItems> _result = new ArrayList<GroceryItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GroceryItems _item;
            final String _tmpItemName;
            _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            final int _tmpItemQuantity;
            _tmpItemQuantity = _cursor.getInt(_cursorIndexOfItemQuantity);
            final int _tmpItemPrice;
            _tmpItemPrice = _cursor.getInt(_cursorIndexOfItemPrice);
            _item = new GroceryItems(_tmpItemName,_tmpItemQuantity,_tmpItemPrice);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
