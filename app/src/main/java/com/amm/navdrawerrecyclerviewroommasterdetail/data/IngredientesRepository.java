package com.amm.navdrawerrecyclerviewroommasterdetail.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.Guisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.GuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.Ingrediente;
import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.IngredienteDao;

import java.util.List;

public class IngredientesRepository {
    //Ingredientes Specifics --------------------------------------
    private IngredienteDao ingredienteDao;
    private LiveData<List<Ingrediente>> ldIngredientes;

    //Guisos Specifics --------------------------------------
    private TiposGuisosDao tiposGuisosDao;
    private GuisosDao guisosDao;
    private LiveData<List<TiposGuisos>> ldTiposGuisos;
    public  LiveData<TiposGuisos> ldTipoGuisos;
    private LiveData<List<Guisos>> ldGuisos;

    //Constructor
    public IngredientesRepository(Application application) {
        //DB Creation
        AppRoomDatabase db = AppRoomDatabase.getDatabase(application);

        //Obteniendo los DAO
        ingredienteDao= db.ingredienteDao();
//        tiposGuisosDao= db.tiposGuisosDao();
//        guisosDao= db.guisosDao();

        //Inicializando los LiveData
        ldIngredientes = ingredienteDao.getIngredientes();
        //ldTiposGuisos = getTiposGuisos();
        //inicializamos el LiveData de Guisos a null porque hasta que no seleccione un tipo no debe cargarse
//        ldGuisos = null;
//        ldTipoGuisos = null;
    }

    //Ingredientes Specifics --------------------------------------
    public LiveData<List<Ingrediente>> getAllIngredientes() {
        return ldIngredientes;
    }

    public void insertIngrediente(Ingrediente ingrediente) {
        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
            ingredienteDao.insert(ingrediente);
        });
    }

    public void insertIngredientes(String[] ingredientes) {
//        //Funciona con más de un thread en el executor porque el trabajo lo recibe uno solo
//        Ingrediente ingredientesArray[] = new Ingrediente[ingredientes.length];
//        for (int i = 0; i < ingredientes.length; i++) {
//            ingredientesArray[i]=new Ingrediente(ingredientes[i]);
//        }
//        IngredientesRoomDatabase.databaseWriteExecutor.execute(() -> {
//            ingredienteDao.insertIngredientes(ingredientesArray);
//        });
        //Con un único thread en el executor
        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
            for (int i = 0; i < ingredientes.length; i++) {
                ingredienteDao.insert(new Ingrediente(ingredientes[i]));
            }
        });
    }

    public void deleteIngrediente(Ingrediente ingrediente){
        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
            ingredienteDao.deleteIngrediente(ingrediente.toString());
            //ingredienteDao.delete(ingrediente);
        });
    }

    public void deleteAllIngredientes(){
        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
            ingredienteDao.deleteAll();
        });
    }

//    //Guisos Specifics --------------------------------------
//    public LiveData<List<TiposGuisos>> getTiposGuisos(){
//        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
//            ldTiposGuisos =  tiposGuisosDao.getTiposGuisos();
//        });
//        return ldTiposGuisos;
//    }
//
//    public LiveData<TiposGuisos> getTipoGuisos(String strTipoGuiso){
//        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
//            ldTipoGuisos =  tiposGuisosDao.getTipoGuisos(strTipoGuiso);
//        });
//        return ldTipoGuisos;
//    }
////
////    public void getIdTipoGuiso(String strTipoGuiso){
////        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
////            ldIdTipoGuiso =  tiposGuisosDao.getTipoId(strTipoGuiso);
////        });
////    }
//
////    public LiveData<List<Guisos>> getGuisos(TiposGuisos tipoGuiso){
////        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
////            ldGuisos = guisosDao.getGuisos(tipoGuiso.getId());
////        });
////        return ldGuisos;
////    }

    //Generic ------------------------------------------------------
    public void forceDBCreation(){
        AppRoomDatabase.databaseWriteExecutor.execute(() -> {
            ingredienteDao.dummyDelete();
        });
    }
}
