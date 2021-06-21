package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;

@Data
@NoArgsConstructor
public abstract class AbstractStrategy  {

    public abstract Integer makeAttackingMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) ;
    public abstract Integer makeDefensiveMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) ;
}
