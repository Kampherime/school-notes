	.orig x3000

MAIN
	JSR GETNUM
	JSR GETNUM
	HALT

GETNUM
	ST R7, R7_ADDR
	ST R2, R2_ADDR
	AND R0, R0, #0
LOOP
	GETC
	; ADD R1, R0, #0
	LD R2, N0
	ADD R0, R0, R2
	BRN LOOP
	ADD R0, R0, #-9
	BRP LOOP
	ADD R0, R0, #9
	LD R7, R7_ADDR
	LD R2, R2_ADDR
	RET

R7_ADDR .fill 0 
R2_ADDR .fill 0
N0 .fill -48
OFFSET .fill #-9
