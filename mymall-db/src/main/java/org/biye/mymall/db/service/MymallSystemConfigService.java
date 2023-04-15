package org.biye.mymall.db.service;

import org.biye.mymall.db.dao.MymallSystemMapper;
import org.biye.mymall.db.domain.MymallSystem;
import org.biye.mymall.db.domain.MymallSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MymallSystemConfigService {
    @Resource
    private MymallSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        MymallSystemExample example = new MymallSystemExample();
        example.or().andDeletedEqualTo(false);

        List<MymallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (MymallSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        MymallSystemExample example = new MymallSystemExample();
        example.or().andKeyNameLike("mymall_mall_%").andDeletedEqualTo(false);
        List<MymallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(MymallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        MymallSystemExample example = new MymallSystemExample();
        example.or().andKeyNameLike("mymall_wx_%").andDeletedEqualTo(false);
        List<MymallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(MymallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        MymallSystemExample example = new MymallSystemExample();
        example.or().andKeyNameLike("mymall_order_%").andDeletedEqualTo(false);
        List<MymallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(MymallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        MymallSystemExample example = new MymallSystemExample();
        example.or().andKeyNameLike("mymall_express_%").andDeletedEqualTo(false);
        List<MymallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(MymallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            MymallSystemExample example = new MymallSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            MymallSystem system = new MymallSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        MymallSystem system = new MymallSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
