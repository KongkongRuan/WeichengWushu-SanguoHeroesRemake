export const REACTION_CONFIG = {
  burningGround: { duration: 16, interval: 4, damage: 4 },
  iceFireBurst: { baseDamage: 20, perTowerLevel: 4, cooldown: 30, radius: 24 },
  limeScald: { poisonConsumed: 16, armorBreakDuration: 30, armorBreakBase: 2 },
  paralyzePierce: { multiplier: 1.25, paralyzeConsumed: 10 },
} as const;

export const REACTION_LABELS: Record<string, string> = {
  oil_ignition: '油火引燃',
  ice_fire_burst: '冰火爆裂',
  lime_scald: '石灰沸灼',
  paralyze_pierce: '麻痹穿刺',
};
