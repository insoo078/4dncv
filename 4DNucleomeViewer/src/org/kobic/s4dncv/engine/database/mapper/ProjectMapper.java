package org.kobic.s4dncv.engine.database.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.s4dncv.engine.database.vo.GeneVo;
import org.kobic.s4dncv.engine.database.vo.HeatMapVo;
import org.kobic.s4dncv.engine.database.vo.HiCInteractionPairCommonVo;
import org.kobic.s4dncv.engine.database.vo.HiCInteractionPairVo;
import org.kobic.s4dncv.engine.database.vo.InteractionVo;
import org.kobic.s4dncv.engine.database.vo.LocusVo;
import org.kobic.s4dncv.engine.database.vo.SampleVo;

public interface ProjectMapper {
	public HiCInteractionPairCommonVo getHicIneractionPairCommonInfo( Map<String, Integer> paramMap );
	public List<HiCInteractionPairVo> getCurrentHicInteractionPairInfo( Map<String, Integer> paramMap );
	public List<InteractionVo> getInteractions( Map<String, Object> paramMap );
	public List<InteractionVo> getInteractions4Convolution( Map<String, Object> paramMap );
	public List<LocusVo> getLocusInfo( Map<String, String> paramMap );
	
	public List<InteractionVo> getAllToAllInteractionPairs( Map<String, Object> paramMap );
	public List<InteractionVo> getAllToAllInteractionPairsGraph( Map<String, Object> paramMap );
	
	public List<GeneVo> getGene( Map<String, Object> paramMap);
	
	public List<HeatMapVo> getHeatMapData( Map<String, String> paramMap);
	public List<HeatMapVo> getHeatMapDataLast( Map<String, String> paramMap);
	public List<HeatMapVo> getCompareHeatMapData2( Map<String, String> paramMap);
	
	public List<SampleVo> getSampleList();
	
	public String getTableName(Map<String, String> map);
	
	public List<String> getAutoCompleteGeneSymbol(Map<String, String> paramMap);
}