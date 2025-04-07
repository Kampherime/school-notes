.orig x3000
MAIN
    JSR COUNTCHAR
    HALT

COUNTCHAR 
    ST R0, R0_ADDR2 ; Code of the char to find
    ST R1, R1_ADDR2 ; String addr 
    ST R2, R2_ADDR2 ; NOT R0 + 1
    ST R3, R3_ADDR2 ; The charactler from R1
    ST R4, R4_ADDR2 ; Count
    ST R5, R5_ADDR2 ; uh
    ST R6, R6_ADDR
    AND R5, R5, #0
    NOT R2, R0
    ADD R2, R2, #1
    LD R3, NA
    AND R4, R4, #0
    ADD R4, R4, R0
COND5
    ADD R4, R3, R4
    BRN NORMLOOP
COND6
    ADD R4, R4, #-15
    ADD R4, R4, #-11
    BRN UCLOOP
COND7
    ADD R4, R4, #-6
    BRN NORMLOOP
COND8
    ADD R4, R4, #-15
    ADD R4, R4, #-16
    BRN LCLOOP

NORMLOOP
    LDR R3, R1, #0
    BRZ FIN2
    ADD R1, R1, #1
    ADD R3, R2, R3
    BRNP NORMLOOP
    ADD R5, R5, #1
    BRNZP NORMLOOP

UCLOOP
    LDR R3, R1, #0
    BRZ FIN2
    ADD R1, R1, #1
    ADD R3, R2, R3
    BRNP LCTEST
    ADD R5, R5, #1
    BRNZP UCLOOP
LCTEST
    LD R4, N32_2
    ADD R4, R4, R3
    BRNP UCLOOP
    ADD R5, R5, #1
    BRNZP UCLOOP


LCLOOP
    LDR R3, R1, #0
    BRZ FIN2
    ADD R1, R1, #1
    ADD R3, R2, R3
    BRNP UCTEST
    ADD R5, R5, #1
    BRNZP LCLOOP
UCTEST
    LD R4, P32_2
    ADD R4, R4, R3
    BRNP LCLOOP
    ADD R5, R5, #1
    BRNZP LCLOOP

FIN2
    LD R0, R0_ADDR2 ; Code of the char to find
    LD R1, R1_ADDR2 ; String addr 
    LD R2, R2_ADDR2 ; NOT R0 + 1
    LD R3, R3_ADDR2 ; The charactler from R1
    LD R4, R4_ADDR2 ; Count
    AND R0, R0, #0
    ADD R0, R5, #0
    LD R5, R5_ADDR2 ; uh
    RET


NA .fill -65
N32_2 .fill -32
P32_2 .fill 32
R0_ADDR2 .fill 0
R1_ADDR2 .fill 0
R2_ADDR2 .fill 0
R3_ADDR2 .fill 0
R4_ADDR2 .fill 0
R5_ADDR2 .fill 0
R6_ADDR .fill 0

.end
