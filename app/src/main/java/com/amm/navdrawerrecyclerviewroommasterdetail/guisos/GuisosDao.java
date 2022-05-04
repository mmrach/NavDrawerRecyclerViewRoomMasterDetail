package com.amm.navdrawerrecyclerviewroommasterdetail.guisos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GuisosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Guisos guiso);

    @Query("SELECT * FROM guisos")
    List<Guisos> getGuisos();

    @Query("SELECT * FROM guisos WHERE id_tipoguisos = :tipoguiso")
    List<Guisos> getGuisosByType(Integer tipoguiso);

}
