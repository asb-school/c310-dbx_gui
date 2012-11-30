package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.NpcType;
import jpa.Region;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-11-30T03:39:57")
@StaticMetamodel(Npc.class)
public class Npc_ { 

    public static volatile SingularAttribute<Npc, Integer> id;
    public static volatile SingularAttribute<Npc, Integer> posY;
    public static volatile SingularAttribute<Npc, Integer> posX;
    public static volatile SingularAttribute<Npc, NpcType> npcTypeId;
    public static volatile SingularAttribute<Npc, Region> regionId;

}