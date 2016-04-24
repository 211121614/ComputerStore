package computerstore.com.computerstore.repository.components;

import android.test.AndroidTestCase;
import junit.framework.Assert;


import java.util.Set;

import computerstore.com.computerstore.domain.components.CPU;
import computerstore.com.computerstore.respository.components.Impl.CPURepositoryImpl;
import computerstore.com.computerstore.respository.components.CPURepository;

/**
 * Created by Aidem on 2016/04/09.
 */
public class CPURepositoryTest  extends AndroidTestCase {
    private static final String TAG="CPU test";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CPURepository repo = new CPURepositoryImpl(this.getContext());
        // CREATE
        CPU createEntity = new CPU.Builder()
                .stock(50)
                .description("COOLERMASTER CM STORM SCOUT 2")
                .price(1699.00)
                .build();
        CPU insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<CPU> cpu = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",cpu.size()>0);

        //READ ENTITY
        CPU entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        CPU updateEntity = new CPU.Builder()
                .CPU(entity)
                .price(1599.00)
                .build();
        repo.update(updateEntity);
        CPU newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",1599.00,newEntity.getPrice());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CPU deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
