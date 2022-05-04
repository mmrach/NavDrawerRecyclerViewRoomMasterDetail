package com.amm.navdrawerrecyclerviewroommasterdetail.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.Guisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.GuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class GuisosRepository {

    private GuisosDao guisosDao;
    private TiposGuisosDao tiposGuisosDao;

    public GuisosRepository(Application application) {
        AppRoomDatabase db = AppRoomDatabase.getDatabase(application);

        //Obteniendo los DAO
        guisosDao= db.guisosDao();
        tiposGuisosDao = db.tiposGuisosDao();
    }

    public List<Guisos> getAllGuisos(){
        List<Guisos> guisos = guisosDao.getGuisos();
        return guisos;
    }

    public List<Guisos> queryGuisosByType(Integer tipoGuiso){
        List<Guisos> guisos = guisosDao.getGuisosByType(tipoGuiso);
        return guisos;
    }


}
