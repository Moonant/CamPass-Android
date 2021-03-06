package net.bingyan.campass.greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig moduleDaoConfig;
    private final DaoConfig cacheDaoConfig;
    private final DaoConfig electricRecordDaoConfig;

    private final ModuleDao moduleDao;
    private final CacheDao cacheDao;
    private final ElectricRecordDao electricRecordDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        moduleDaoConfig = daoConfigMap.get(ModuleDao.class).clone();
        moduleDaoConfig.initIdentityScope(type);

        cacheDaoConfig = daoConfigMap.get(CacheDao.class).clone();
        cacheDaoConfig.initIdentityScope(type);

        electricRecordDaoConfig = daoConfigMap.get(ElectricRecordDao.class).clone();
        electricRecordDaoConfig.initIdentityScope(type);

        moduleDao = new ModuleDao(moduleDaoConfig, this);
        cacheDao = new CacheDao(cacheDaoConfig, this);
        electricRecordDao = new ElectricRecordDao(electricRecordDaoConfig, this);

        registerDao(Module.class, moduleDao);
        registerDao(Cache.class, cacheDao);
        registerDao(ElectricRecord.class, electricRecordDao);
    }
    
    public void clear() {
        moduleDaoConfig.getIdentityScope().clear();
        cacheDaoConfig.getIdentityScope().clear();
        electricRecordDaoConfig.getIdentityScope().clear();
    }

    public ModuleDao getModuleDao() {
        return moduleDao;
    }

    public CacheDao getCacheDao() {
        return cacheDao;
    }

    public ElectricRecordDao getElectricRecordDao() {
        return electricRecordDao;
    }

}
